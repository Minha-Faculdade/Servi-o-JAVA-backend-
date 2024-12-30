package scraping;  // Defina o pacote aqui

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SeriesScraper {
    public static void main(String[] args) {
        try {
            // URL da página que contém a lista das séries mais assistidas de 2024
            String url = "https://www.adorocinema.com/series-tv/melhores/decada-2020/ano-2024/";

            // Conectar à página e obter o documento HTML
            Document doc = Jsoup.connect(url).get();

            // Selecionar os elementos que contêm os títulos das séries
            Elements seriesElements = doc.select(".meta-title-link");

            // Iterar sobre os elementos e extrair os títulos das séries
            for (Element seriesElement : seriesElements) {
                String title = seriesElement.text(); // Obtém o texto (título da série)
                System.out.println("Série: " + title); // Exibe o título da série
            }
        } catch (Exception e) {
            e.printStackTrace(); // Se ocorrer algum erro, ele será impresso
        }
    }
}
