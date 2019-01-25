package com.atmapp.core.xmlParser;

import com.atmapp.core.banks.Bank;
import com.atmapp.core.card.Card;
import com.atmapp.core.enums.CardBrand;
import com.atmapp.core.enums.Currency;
import com.atmapp.core.enums.IssuerBank;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Parser {
    public  List<Card> xmlParser() {
        List<Card> cardList = new ArrayList();

        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = null;

            documentBuilder = documentBuilderFactory.newDocumentBuilder();

            Document document = null;
            document = documentBuilder.parse(new File("D:\\1Emilia\\atmapps\\src\\main\\resources\\cards.xml"));


            document.getDocumentElement().normalize();

            NodeList nList = document.getElementsByTagName("card");


            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element el = (Element) node;
                    String cardnumber = el.getElementsByTagName("cardnumber").item(0).getTextContent();
                    CardBrand cardbrand = CardBrand.valueOf(el.getElementsByTagName("cardbrand").item(0).getTextContent());
                    Currency currency = Currency.valueOf(el.getElementsByTagName("currency").item(0).getTextContent());
                    Bank issuerbank = IssuerBank.valueOf(el.getElementsByTagName("issuerbank").item(0).getTextContent()).getInstance();
                    String cardholder = el.getElementsByTagName("cardholder").item(0).getTextContent();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
                    Date expiredate = null;
                    expiredate = formatter.parse(el.getElementsByTagName("expiredate").item(0).getTextContent());


                    cardList.add(new Card.CardCreater().setCardnumber(cardnumber).setCardBrand(cardbrand).setCurrency(currency).setIssuerbank(issuerbank).setCardholder(cardholder).setExpiredate(expiredate).build());
                }
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return cardList;
    }

}
