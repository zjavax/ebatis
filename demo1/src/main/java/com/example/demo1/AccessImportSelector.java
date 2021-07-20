package com.example.demo1;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

public class AccessImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        //读取EnableAccess中所有的属性方法
        Map<String, Object> annotationAttributes =  annotationMetadata.getAnnotationAttributes(EnableAccess.class.getName());
        //获取属性为type的属性方法
        Access.Type type = (Access.Type )annotationAttributes.get("type");
        //导入的类名称数组
        String [] importClassName = new String[0];
        switch (type){
            case RPC:
                //设置为RPC，返回RpcAccess组件
                importClassName = new String[]{RpcAccess.class.getName()};
                break;
            case REST:
                //设置为REST，返回RestAccess组件
                importClassName = new String[]{RestAccess.class.getName()};
        }
        return importClassName;
    }
}
