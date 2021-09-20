package tk.cavalks.issfortaleza.services;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

import br.com.issfortaleza.producao.ServiceGinfesImplServiceServiceStub;

// TODO Parametrizar a montagem do xml
// TODO Criar classes Java referente aos objetos do xmlEnvio
// TODO Chavear prod x homol
// TODO tramento das exceções
public class EnvioRPSService {
	public static final String schemaFolder = "";

	public static String enviarLoteRPS() throws Exception {
		File arquivoPFX = new File("C:"+File.separator+"CAVALKS.pfx");
		XMLSecImpl assinador = new XMLSecImpl();

		String xmlEnvio = RpsToXML(new HashMap<String, String>());
		validateLoteRPS(xmlEnvio);
		xmlEnvio = assinador.assinarEnvioLoteRPS(xmlEnvio, arquivoPFX, "12345678");

		ServiceGinfesImplServiceServiceStub stub = new ServiceGinfesImplServiceServiceStub(
				"http://isshomo.sefin.fortaleza.ce.gov.br/grpfor-iss/ServiceGinfesImplService");
		ServiceGinfesImplServiceServiceStub.RecepcionarLoteRpsV3 req = new ServiceGinfesImplServiceServiceStub.RecepcionarLoteRpsV3();
		req.setCabecalho(getXMLCabecalho());
		req.setEnviarLoteRpsEnvio(xmlEnvio);

		ServiceGinfesImplServiceServiceStub.RecepcionarLoteRpsV3Response res = stub.RecepcionarLoteRpsV3(req);
		return res.getEnviarLoteRpsResposta();
	}

	public static String RpsToXML(Map<String, String> loteRps) {
		StringBuilder envioLoteRPS = new StringBuilder();
		envioLoteRPS.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		envioLoteRPS.append("<EnviarLoteRpsEnvio xmlns=\"http://www.ginfes.com.br/servico_enviar_lote_rps_envio_v03.xsd\" xmlns:ns3=\"http://www.ginfes.com.br/tipos_v03.xsd\">");
		envioLoteRPS.append("  <LoteRps Id=\"8171\">");
		envioLoteRPS.append("    <ns3:NumeroLote>1234</ns3:NumeroLote>");
		envioLoteRPS.append("    <ns3:Cnpj>01234567891234</ns3:Cnpj>");
		envioLoteRPS.append("    <ns3:InscricaoMunicipal>123456</ns3:InscricaoMunicipal>");
		envioLoteRPS.append("    <ns3:QuantidadeRps>1</ns3:QuantidadeRps>");
		envioLoteRPS.append("    <ns3:ListaRps>");
		envioLoteRPS.append("      <ns3:Rps>");
		envioLoteRPS.append("        <ns3:InfRps>");
		envioLoteRPS.append("          <ns3:IdentificacaoRps>");
		envioLoteRPS.append("            <ns3:Numero>2</ns3:Numero>");
		envioLoteRPS.append("            <ns3:Serie>1</ns3:Serie>");
		envioLoteRPS.append("            <ns3:Tipo>1</ns3:Tipo>");
		envioLoteRPS.append("          </ns3:IdentificacaoRps>");
		envioLoteRPS.append("          <ns3:DataEmissao>2014-09-03T10:21:45</ns3:DataEmissao>");
		envioLoteRPS.append("          <ns3:NaturezaOperacao>1</ns3:NaturezaOperacao>");
		envioLoteRPS.append("          <ns3:RegimeEspecialTributacao>1</ns3:RegimeEspecialTributacao>");
		envioLoteRPS.append("          <ns3:OptanteSimplesNacional>2</ns3:OptanteSimplesNacional>");
		envioLoteRPS.append("          <ns3:IncentivadorCultural>2</ns3:IncentivadorCultural>");
		envioLoteRPS.append("          <ns3:Status>1</ns3:Status>");
		envioLoteRPS.append("          <ns3:Servico>");
		envioLoteRPS.append("            <ns3:Valores>");
		envioLoteRPS.append("              <ns3:ValorServicos>1000.00</ns3:ValorServicos>");
		envioLoteRPS.append("              <ns3:ValorDeducoes>0.00</ns3:ValorDeducoes>");
		envioLoteRPS.append("              <ns3:ValorPis>0.00</ns3:ValorPis>");
		envioLoteRPS.append("              <ns3:ValorCofins>0.00</ns3:ValorCofins>");
		envioLoteRPS.append("              <ns3:ValorInss>0.00</ns3:ValorInss>");
		envioLoteRPS.append("              <ns3:ValorIr>0.00</ns3:ValorIr>");
		envioLoteRPS.append("              <ns3:ValorCsll>0.00</ns3:ValorCsll>");
		envioLoteRPS.append("              <ns3:IssRetido>2</ns3:IssRetido>");
		envioLoteRPS.append("              <ns3:ValorIss>50.00</ns3:ValorIss>");
		envioLoteRPS.append("              <ns3:ValorIssRetido>0.00</ns3:ValorIssRetido>");
		envioLoteRPS.append("              <ns3:OutrasRetencoes>0.00</ns3:OutrasRetencoes>");
		envioLoteRPS.append("              <ns3:BaseCalculo>1000.0</ns3:BaseCalculo>");
		envioLoteRPS.append("              <ns3:Aliquota>0.05</ns3:Aliquota>");
		envioLoteRPS.append("              <ns3:ValorLiquidoNfse>1000.0</ns3:ValorLiquidoNfse>");
		envioLoteRPS.append("              <ns3:DescontoIncondicionado>0.00</ns3:DescontoIncondicionado>");
		envioLoteRPS.append("              <ns3:DescontoCondicionado>0.00</ns3:DescontoCondicionado>");
		envioLoteRPS.append("            </ns3:Valores>");
		envioLoteRPS.append("            <ns3:ItemListaServico>9.99</ns3:ItemListaServico>");
		envioLoteRPS.append("            <ns3:CodigoTributacaoMunicipio>999999999</ns3:CodigoTributacaoMunicipio>");
		envioLoteRPS.append("            <ns3:Discriminacao>XML DE EXEMPLO</ns3:Discriminacao>");
		envioLoteRPS.append("            <ns3:CodigoMunicipio>2304400</ns3:CodigoMunicipio>");
		envioLoteRPS.append("          </ns3:Servico>");
		envioLoteRPS.append("          <ns3:Prestador>");
		envioLoteRPS.append("            <ns3:Cnpj>01234567891234</ns3:Cnpj>");
		envioLoteRPS.append("            <ns3:InscricaoMunicipal>123456</ns3:InscricaoMunicipal>");
		envioLoteRPS.append("          </ns3:Prestador>");
		envioLoteRPS.append("          <ns3:Tomador>");
		envioLoteRPS.append("            <ns3:IdentificacaoTomador>");
		envioLoteRPS.append("              <ns3:CpfCnpj>");
		envioLoteRPS.append("                <ns3:Cnpj>01234567891234</ns3:Cnpj>");
		envioLoteRPS.append("              </ns3:CpfCnpj>");
		envioLoteRPS.append("              <ns3:InscricaoMunicipal>123456</ns3:InscricaoMunicipal>");
		envioLoteRPS.append("            </ns3:IdentificacaoTomador>");
		envioLoteRPS.append("            <ns3:RazaoSocial>RAZAO SOCIAL DE EXEMPLO</ns3:RazaoSocial>");
		envioLoteRPS.append("            <ns3:Endereco>");
		envioLoteRPS.append("              <ns3:Endereco>RUA TESTE</ns3:Endereco>");
		envioLoteRPS.append("              <ns3:Numero>123</ns3:Numero>");
		envioLoteRPS.append("              <ns3:Complemento>APARTAMENTO 302</ns3:Complemento>");
		envioLoteRPS.append("              <ns3:Bairro>TESTE</ns3:Bairro>");
		envioLoteRPS.append("              <ns3:CodigoMunicipio>2304400</ns3:CodigoMunicipio>");
		envioLoteRPS.append("              <ns3:Uf>CE</ns3:Uf>");
		envioLoteRPS.append("              <ns3:Cep>60000000</ns3:Cep>");
		envioLoteRPS.append("            </ns3:Endereco>");
		envioLoteRPS.append("            <ns3:Contato>");
		envioLoteRPS.append("              <ns3:Telefone>8531010001</ns3:Telefone>");
		envioLoteRPS.append("              <ns3:Email>email@exemplo.com.br</ns3:Email>");
		envioLoteRPS.append("            </ns3:Contato>");
		envioLoteRPS.append("          </ns3:Tomador>");
		envioLoteRPS.append("        </ns3:InfRps>");
		envioLoteRPS.append("      </ns3:Rps>");
		envioLoteRPS.append("    </ns3:ListaRps>");
		envioLoteRPS.append("  </LoteRps>");
		envioLoteRPS.append("</EnviarLoteRpsEnvio>");
		return envioLoteRPS.toString();
	}

	public static String getXMLCabecalho() {
		String xmlCabecalho = "";
		xmlCabecalho += "<cabecalho xmlns=\"http://www.abrasf.org.br/nfse.xsd\" versao=\"1.00\">";
		xmlCabecalho += "   <versaoDados>";
		xmlCabecalho += "      3.00";
		xmlCabecalho += "   </versaoDados >";
		xmlCabecalho += "</cabecalho>";
		return xmlCabecalho;
	}
	
	public static void validateLoteRPS(String xml) throws SAXException, IOException, URISyntaxException {
		String arquivoXSD = "xsd/servico_enviar_lote_rps_envio_v03.xsd";
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(new File(EnvioRPSService.class.getClassLoader().getResource(arquivoXSD).toURI()));
		Validator validator = schema.newValidator();
		validator.validate(new StreamSource(new StringReader(xml)));
	}
}
