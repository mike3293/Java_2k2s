package Tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.ArrayList;

public class GMPTable extends SimpleTagSupport {
    private ArrayList<Object> objects;

    public void setObjects(ArrayList<Object> objects) {
        this.objects = objects;
    }

    public GMPTable() {
    }

    @Override
    public void doTag() throws JspException, IOException {
        try {
            String outputText = "<table>";
            for (Object obj:objects
                 ) {
                outputText+="<tr><td>"+obj.toString()+"<hr></td></tr>";
            }
            outputText += "</table>";
            getJspContext().getOut().write(outputText);
        } catch (Exception e) {
            e.printStackTrace();
            // stop page from loading further by throwing SkipPageException
            throw new SkipPageException("Exception in TLD");
        }
    }

}