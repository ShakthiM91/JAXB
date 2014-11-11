JAXB
=============================
Create Java definition classes from xml schema file using 'xjc' tool in Java jdk. 
'xjc -p demo demo.xsd'

This simple program will use those definition classes to read from xml file and write to an xml file.

Reading file - demo.xml
Writting file - output.xml

both of these file can be found at the root of folder structure. 

This program only will write one static value to the xml file.

About src
===============================
Source contan two packages. 
One package contains xml file and xsd file that used to create the java class definitions for the xml file. 
The other package holds the java definition classes for the xml file and the program that read from the xml file and
write to the xml file.
