/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

/**
 *
 * @author shakthi
 */
public class Prog {

    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance("demo");
        Unmarshaller unmarshaller = context.createUnmarshaller();
				//unmarshaller.setValidating(true);
        //PersonType person =	(PersonType) unmarshaller.unmarshal(new File("demo.xml") );
        
        Source source = new StreamSource(new File("demo.xml"));
        JAXBElement<PersonType> root = unmarshaller.unmarshal(source, PersonType.class);
        PersonType person = root.getValue();

        System.out.println("Person name=" + person.getName());
        AddressType address = (AddressType) person.getAddress().get(0);
        System.out.println("First Address: " + " Street=" + address.getStreet() + " Number=" + address.getNumber());

        // Update
        person.setName("Shakthi Manawadu");
        // Delete
        List<AddressType> addressList = person.getAddress();
        addressList.clear();

        // Create
        ObjectFactory objectFactory = new ObjectFactory();
        AddressType newAddr = objectFactory.createAddressType();
        newAddr.setStreet("Colombo");
        newAddr.setNumber(5);
        addressList.add(newAddr);

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(person, new FileOutputStream("output.xml"));

    }
}
