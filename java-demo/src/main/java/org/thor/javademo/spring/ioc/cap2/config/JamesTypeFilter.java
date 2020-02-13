package org.thor.javademo.spring.ioc.cap2.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

public class JamesTypeFilter implements TypeFilter{
	private ClassMetadata classMetadata;

	/**
	 *
	 * @param metadataReader 读取到当前正在扫描的累信息
	 * @param metadataReaderFactory 可以获取到其他任何类信息
	 * @return
	 * @throws IOException
	 */
	@Override
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
			throws IOException {
		// 获取当前类注解信息
		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		// 获取当前扫描的类信息
		classMetadata = metadataReader.getClassMetadata();
		// 获取当前类资源（类的路径）
		Resource resource = metadataReader.getResource();

		String className = classMetadata.getClassName();
		System.out.println("----->"+className);
		//当类名包含er，则匹配成功
		if(className.contains("Order")){
			return true;
		}
		return false;
	}

}
