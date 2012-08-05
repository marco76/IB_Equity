package ch.genidea.greed.web.mb;

import ch.genidea.greed.ib.bean.Equity;
import ch.genidea.greed.ib.bean.EquityDailyComment;
import ch.genidea.greed.ib.service.EquityDailyCommentService;
import ch.genidea.greed.ib.service.EquityService;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.primefaces.model.UploadedFile;
import org.springframework.context.annotation.Scope;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/28/12
 * Time: 8:17 PM
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean(name="equityDailyCommentPage")
@SessionScoped
@Scope("request")
public class EquityDailyCommentPage implements Serializable{

    @ManagedProperty("#{equityDailyCommentService}")
    private EquityDailyCommentService equityDailyCommentService;

    @ManagedProperty("#{equityService}")
    private EquityService equityService;
    private UploadedFile file;
    private String fileName;
    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }




private List<EquityDailyComment> equityDailyCommentList;
    private EquityDailyComment selectedDailyComment;

    public String loadPage(Long equityId){
        selectedDailyComment = new EquityDailyComment();
        Equity equity = equityService.getById(equityId);
        selectedDailyComment.setEquity(equity);
      equityDailyCommentList = equityDailyCommentService.getCommentsByEquityId(equityId);
        return "listEquityDailyComment";
    }

    public EquityDailyCommentService getEquityDailyCommentService() {
        return equityDailyCommentService;
    }

    public void setEquityDailyCommentService(EquityDailyCommentService equityDailyCommentService) {
        this.equityDailyCommentService = equityDailyCommentService;
    }

    public List<EquityDailyComment> getEquityDailyCommentList() {
        return equityDailyCommentList;
    }

    public void setEquityDailyCommentList(List<EquityDailyComment> equityDailyCommentList) {
        this.equityDailyCommentList = equityDailyCommentList;
    }

    public String saveSelectedComment(){
        if (file != null)
          selectedDailyComment.setPictureName1(file.getFileName());
       equityDailyCommentService.save(selectedDailyComment);

        // Prepare file and outputstream.
        File newfile = null;
        OutputStream output = null;
        if (file!=null){
        try {
            // Just to demonstrate what information you can get from the uploaded file.
            // Prepare filename prefix and suffix for an unique filename in upload folder.
            String prefix = FilenameUtils.getBaseName(file.getFileName());
            String suffix = FilenameUtils.getExtension(file.getFileName());

            // Create file with unique name in upload folder and write to it.
            newfile = File.createTempFile(selectedDailyComment.getDateInt()+"_"+selectedDailyComment.getEquityId()+ "_", "." + suffix, new File("/Users/marco/Documents/greedImages"));
            output = new FileOutputStream(newfile);
            IOUtils.copy(file.getInputstream(), output);
            fileName = newfile.getName();

            // Show succes message.
            FacesContext.getCurrentInstance().addMessage("uploadForm", new FacesMessage(
                    FacesMessage.SEVERITY_INFO, "File upload succeed!", null));
        } catch (IOException e) {
            // Cleanup.
            if (newfile != null) newfile.delete();

            // Show error message.
            FacesContext.getCurrentInstance().addMessage("uploadForm", new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "File upload failed with I/O error.", null));

            // Always log stacktraces (with a real logger).
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(output);
        }
        }


        return null;
    }

    public EquityService getEquityService() {
        return equityService;
    }

    public void setEquityService(EquityService equityService) {
        this.equityService = equityService;
    }

    public EquityDailyComment getSelectedDailyComment() {
        return selectedDailyComment;
    }

    public void setSelectedDailyComment(EquityDailyComment selectedDailyComment) {
        this.selectedDailyComment = selectedDailyComment;
    }
}