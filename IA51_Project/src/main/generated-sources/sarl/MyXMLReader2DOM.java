import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

@SarlSpecification("0.9")
@SarlElementType(10)
@SuppressWarnings("all")
public class MyXMLReader2DOM {
  public static void main(final String[] args) {
    try {
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
      DocumentBuilder db = dbf.newDocumentBuilder();
      Document document = db.parse("Schedule1.xml");
      NodeList EpisodeList = document.getElementsByTagName("Episode");
      int _length = EpisodeList.getLength();
      System.out.println((("一共有" + Integer.valueOf(_length)) + "本书"));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @SyntheticMember
  public MyXMLReader2DOM() {
    super();
  }
}
