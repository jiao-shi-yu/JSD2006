package io.stream.object;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 用来测试对象流的读写操作
 * 
 * 对象流读写的对象，对应类必须实现 Serializable 接口。
 * 
 * Serializable 接口里面，完全是空的，就是为了标明这个类可以被实例化。
 * @author yuyu
 *
 */
public class Person implements Serializable {
	
	/**
	 * 自动生成的一个版本 ID，
	 * 即便这个类后面增加了新的属性，
	 * 进行反序列化的时候，只要这个版本 ID 对的上就行。
	 * 对于新增的属性，会用新增属性类型的默认值来填充。
	 */
	private static final long serialVersionUID = -7278098754284076983L;
	private String name;
	private int age;
	private String gender;
	
	/**
	 * transient 关键字
	 * 被 transient 关键字修饰的属性，在序列化时会被忽略。
	 * 忽略不必要的属性，序列化的到的字节文件就会变小，减少资源开销。
	 */
	private transient String[] otherInfo;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String[] getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(String[] otherInfo) {
		this.otherInfo = otherInfo;
	}
	
	public Person(String name, int age, String gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + ", otherInfo="
				+ Arrays.toString(otherInfo) + "]";
	}
	
	
}
