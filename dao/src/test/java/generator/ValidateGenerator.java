package generator;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ValidateGenerator {
	
    public static boolean isGenerate() throws Exception {
    	String fileName = null;//项目路径
        String filePackage = null ;//包路径
    	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            List<String> warnings = new ArrayList<String>();
			DocumentBuilder builder = dbf.newDocumentBuilder();
            boolean overwrite = true;
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream is = classloader.getResourceAsStream("generatorConfig3.xml");
            Document doc = builder.parse(is);//获取dom节点
            Element root = doc.getDocumentElement();
            if (root == null) return false;
            // all college node   
            NodeList collegeNodes = root.getChildNodes();//获取根节点下的所有子节点
            if (collegeNodes == null) return false;
            for (int i = 0; i < collegeNodes.getLength(); i++) {
				Node college = collegeNodes.item(i);
				 if (college != null && college.getNodeType() == Node.ELEMENT_NODE) {  
	                    // all class node   
	                    NodeList classNodes = college.getChildNodes();//获取下面的所有节点
	                    if (classNodes == null) continue;  
	                    for (int j = 0; j < classNodes.getLength(); j++) {  
	                        Node clazz = classNodes.item(j);
	                        if(clazz == null) continue;
	                        if (clazz != null && clazz.getNodeType() == Node.ELEMENT_NODE) {  
	                            String nodeName = clazz.getNodeName();
	                            //根据配置文件获取项目的路径
	                            if(nodeName.equals("javaModelGenerator")){
	                            	NamedNodeMap map = clazz.getAttributes();
	                            	for(int t = 0; t<map.getLength(); t++){    
	                                    Node nodeJavaModel = map.item(t);    
	                                    //通过Node对象的getNodeName()和getNodeValue()方法获取属性名和属性值
	                                    if(nodeJavaModel == null) continue;
	                                    //获取项目的包路径
	                                    if(nodeJavaModel.getNodeName().equals("targetPackage")){
	                                    	filePackage = nodeJavaModel.getNodeValue();
	                                    	filePackage = filePackage.replace(".", "\\");
	                                    }
	                                    //获取项目路径
	                                    if(nodeJavaModel.getNodeName().equals("targetProject")){
	                                    	fileName = nodeJavaModel.getNodeValue();
	                                    	fileName = fileName.replace("\\", "/");
	                                    	break;
	                                    }
	                                }  
	                            }
	                            if(fileName != null && fileName != ""){
	                            	if(nodeName.equals("table")){
	                            		//获取这个节点的所有属性
		                            	NamedNodeMap nodeMap = clazz.getAttributes();
		                            	//循环遍每一个元素的属性值    
		                                for(int k = 0; k<nodeMap.getLength(); k++){    
		                                    Node node = nodeMap.item(k);    
		                                    //通过Node对象的getNodeName()和getNodeValue()方法获取属性名和属性值
		                                    if(node == null) continue;
		                                    if(node.getNodeName().equals("domainObjectName")){
		                                    	String nodeValue =fileName+"\\"+filePackage+"\\"+node.getNodeValue()+".java";
		                                    	boolean saveFile = SaveFile(nodeValue);//判断此文件是否存在
		                                    	if(saveFile){
		                                    		 return  false;
		                                    	}
		                                    }
		                                }  
		                            }
	                            }
	                        }  
	                    }  
	                }  
			}
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  true;
	}
    //判断该路劲下面是否包含指定的文件
    public static boolean SaveFile(String fileName) throws IOException{
        File file =new File(fileName);
        if(!file.exists()){       
            return false;
        } 
        return true;
    }
    
    
    
}