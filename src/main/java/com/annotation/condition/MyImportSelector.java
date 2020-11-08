package com.annotation.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

//自定义需要返回的组件
public class MyImportSelector implements ImportSelector {
    @Override
    //返回值就是需要导入的全类名
    //AnnotationMetadata：标注 当前类的 所有注解信息
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
//        importingClassMetadata.
        //返回对象不要返回null值
        return new String[]{"com.annotation.bean.Dog"};
    }
}
