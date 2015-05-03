package XMLService;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 * A data structure to store system configurations
 * Algorithm still need improvement
 * @author Administrator
 *
 */
public class Configuration {
	//cooresponse to the nodeName
	private String name;
	//nodeValue if text
	private String text;
	private Hashtable<String, String> attributes;
	private Hashtable<String, Configuration> children;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the value
	 */
	public String getText() {
		return text;
	}
	/**
	 * hasText will be set to true automatically
	 * @param value the value to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	public void addAttribute(String name, String value){
		if(this.attributes == null){
			attributes = new Hashtable<String, String>();
		}
		this.attributes.put(name, value);
	}
	
	public String getAttributeValue(String name){
		if(attributes == null){
			return null;
		}
		return this.attributes.get(name);
	}
	
	public Enumeration<String> getAllAttributes(){
		if(this.attributes == null){
			return null;
		}
		return this.attributes.elements();
	}
	
	public Enumeration<String> getAllAttributesNames(){
		if(this.attributes == null){
			return null;
		}
		return this.attributes.keys();
	}
	
	public void addChild(String name, Configuration c){
		if(this.children == null){
			children = new Hashtable<String, Configuration>();
		}
		this.children.put(name, c);
	}
	
	public void addChild(Configuration c){
		if(this.children == null){
			children = new Hashtable<String, Configuration>();
		}
		this.children.put(c.getName(), c);
	}
	
	public Configuration getChild(String name){
		if(this.children == null){
			return null;
		}
		return this.children.get(name);
	}
	
	public Enumeration<Configuration> getAllChildren(){
		if(this.children == null){
			return null;
		}
		return this.children.elements();
	}
	
	public boolean hasText(){
		return !(this.text == null);
	}
	
	public boolean hasAttributes(){
		return !(this.attributes == null);
	}
	
	/**
	 * Remove the child indicated by its name
	 * @param name
	 * @return
	 */
	public Configuration removeChild(String name){
		if(this.children != null){
			return this.children.remove(name);
		}
		return null;
	}
}
