package io.manbang.ebatis.spring.cluster;

import org.springframework.context.ApplicationContext;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author 章多亮
 * @since 2020/6/3 10:51
 */
class ApplicationContextDelegate {
    private static final AtomicReference<ApplicationContext> CONTEXT_HOLDER = new AtomicReference<>();

    private ApplicationContextDelegate() {
        throw new UnsupportedOperationException();
    }

    static <T> T getBean(String name, Class<T> beanClass) {
        return Optional.ofNullable(CONTEXT_HOLDER.get()).map(context -> context.getBean(name, beanClass)).orElse(null);
    }

    static <T> T getBean(Class<T> beanClass) {
        return Optional.ofNullable(CONTEXT_HOLDER.get()).map(context -> context.getBean(beanClass)).orElse(null);
    }

    // 为甚这里明明调用了，却用快捷键不行
    static void setContext(ApplicationContext context) {
        ApplicationContextDelegate.CONTEXT_HOLDER.compareAndSet(null, context);
    }
}
