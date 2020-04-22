spring boot 和 spring mvc 使用 jackson 包处理 忽略 null 字段返回
springmvc 框架默认使用 jackson 出来 json 返回，fastjson 默认是不序列化输出 null 字段的，而 jackson 默认则是输出 null 字段。

xml 配置 spring mvc 的 json 返回忽略 null 字段
<mvc:annotation-driven>
    <mvc:message-converters register-defaults="true">
        <bean class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter">
            <property name="objectMapper">
                <bean class="com.fasterxml.jackson.databind.ObjectMapper">
                    <property name="serializationInclusion">
                        <value type="com.fasterxml.jackson.annotation.JsonInclude.Include">NON_NULL</value>
                    </property>
                </bean>
            </property>
        </bean>
    </mvc:message-converters>
</mvc:annotation-driven>
spring boot 配置忽略 json 的 null 字段返回
spring boot 小于 1.3 时 只能使用编程方式处理
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class Shop {
    //...
}
spring boot 从 1.3 开始可以直接在 application.properties 文件配置
jackson 2.7 以前版本， 参考： https://stackoverflow.com/questions/30042507/for-spring-boot-1-2-3-how-to-set-ignore-null-value-in-json-serialization
spring.jackson.serialization-inclusion=non_null

jackson 现在版本配置， 参考： http://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#howto-customize-the-jackson-objectmapper
spring.jackson.default-property-inclusion=non_null