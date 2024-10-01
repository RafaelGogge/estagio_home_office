/*

3) Dado um vetor que guarda o valor de faturamento diário de uma distribuidora, faça um programa, na linguagem que desejar, que calcule e retorne:
• O menor valor de faturamento ocorrido em um dia do mês;
• O maior valor de faturamento ocorrido em um dia do mês;
• Número de dias no mês em que o valor de faturamento diário foi superior à média mensal.

IMPORTANTE:
a) Usar o json ou xml disponível como fonte dos dados do faturamento mensal;
b) Podem existir dias sem faturamento, como nos finais de semana e feriados. Estes dias devem ser ignorados no cálculo da média;

*/


import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

public class FaturamentoXML {
    
    public static void main(String[] args) {
        String xmlData = 
        "<faturamento>" +
            "<row><dia>1</dia><valor>31490.7866</valor></row>" +
            "<row><dia>2</dia><valor>37277.9400</valor></row>" +
            "<row><dia>3</dia><valor>37708.4303</valor></row>" +
            "<row><dia>4</dia><valor>0.0000</valor></row>" +
            "<row><dia>5</dia><valor>0.0000</valor></row>" +
            "<row><dia>6</dia><valor>17934.2269</valor></row>" +
            "<row><dia>7</dia><valor>0.0000</valor></row>" +
            "<row><dia>8</dia><valor>6965.1262</valor></row>" +
            "<row><dia>9</dia><valor>24390.9374</valor></row>" +
            "<row><dia>10</dia><valor>14279.6481</valor></row>" +
            "<row><dia>11</dia><valor>0.0000</valor></row>" +
            "<row><dia>12</dia><valor>0.0000</valor></row>" +
            "<row><dia>13</dia><valor>39807.6622</valor></row>" +
            "<row><dia>14</dia><valor>27261.6304</valor></row>" +
            "<row><dia>15</dia><valor>39775.6434</valor></row>" +
            "<row><dia>16</dia><valor>29797.6232</valor></row>" +
            "<row><dia>17</dia><valor>17216.5017</valor></row>" +
            "<row><dia>18</dia><valor>0.0000</valor></row>" +
            "<row><dia>19</dia><valor>0.0000</valor></row>" +
            "<row><dia>20</dia><valor>12974.2000</valor></row>" +
            "<row><dia>21</dia><valor>28490.9861</valor></row>" +
            "<row><dia>22</dia><valor>8748.0937</valor></row>" +
            "<row><dia>23</dia><valor>8889.0023</valor></row>" +
            "<row><dia>24</dia><valor>17767.5583</valor></row>" +
            "<row><dia>25</dia><valor>0.0000</valor></row>" +
            "<row><dia>26</dia><valor>0.0000</valor></row>" +
            "<row><dia>27</dia><valor>3071.3283</valor></row>" +
            "<row><dia>28</dia><valor>48275.2994</valor></row>" +
            "<row><dia>29</dia><valor>10299.6761</valor></row>" +
            "<row><dia>30</dia><valor>39874.1073</valor></row>" +
        "</faturamento>";

        try {
            JAXBContext context = JAXBContext.newInstance(FaturamentoMensal.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            FaturamentoMensal faturamento = (FaturamentoMensal) unmarshaller.unmarshal(new StringReader(xmlData));

            double menorValor = Double.MAX_VALUE;
            double maiorValor = Double.MIN_VALUE;
            double soma = 0;
            int diasComFaturamento = 0;

            for (Row row : faturamento.getRows()) {
                double valor = row.getValor();
                if (valor > 0) {
                    if (valor < menorValor) {
                        menorValor = valor;
                    }
                    if (valor > maiorValor) {
                        maiorValor = valor;
                    }
                    soma += valor;
                    diasComFaturamento++;
                }
            }

            double mediaMensal = (diasComFaturamento > 0) ? (soma / diasComFaturamento) : 0;

            int diasAcimaDaMedia = 0;
            for (Row row : faturamento.getRows()) {
                if (row.getValor() > mediaMensal) {
                    diasAcimaDaMedia++;
                }
            }

            System.out.printf("Menor valor de faturamento: R$ %.2f%n", menorValor);
            System.out.printf("Maior valor de faturamento: R$ %.2f%n", maiorValor);
            System.out.printf("Número de dias com faturamento acima da média mensal: %d%n", diasAcimaDaMedia);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}

@XmlRootElement(name = "row")
class Row {
    private int dia;
    private double valor;

    @XmlElement
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    @XmlElement
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}

@XmlRootElement(name = "faturamento")
class FaturamentoMensal {
    private List<Row> rows = new ArrayList<>();

    @XmlElement(name = "row")
    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }
}
