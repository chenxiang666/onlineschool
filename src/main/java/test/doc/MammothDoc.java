package test.doc;
import org.zwobble.mammoth.DocumentConverter;
import org.zwobble.mammoth.Result;

import java.io.File;
import java.io.IOException;
import java.util.Set;

/**
 * @author lwx
 * @date 5/13/17
 * @email liufreeo@gmail.com
 */
public class MammothDoc {
    public static void main(String[] args) throws IOException {
        DocumentConverter converter = new DocumentConverter();
        Result<String> result = converter.convertToHtml(new File("/home/liufree/ll.docx"));
        String html = result.getValue(); // The generated HTML
        System.out.println(html);
        Set<String> warnings = result.getWarnings(); // Any warnings during conversion
    }


}
