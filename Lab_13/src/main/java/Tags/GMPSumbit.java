package Tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class GMPSumbit extends SimpleTagSupport {
    private String label;

    public void setLabel(String label) {
        this.label = label;
    }

    public GMPSumbit() {
    }

    @Override
    public void doTag() throws JspException, IOException {
        try {
            String outputText = String.format("<input type=\"submit\" value=\"%s\">",label);
            getJspContext().getOut().write(outputText);
        } catch (Exception e) {
            e.printStackTrace();
            // stop page from loading further by throwing SkipPageException
            throw new SkipPageException("Exception in TLD");
        }
    }

}