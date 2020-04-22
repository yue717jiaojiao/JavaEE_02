package code.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Configuration
public class TestBean {
    private long id;
    private String name;

    public TestBean(){

    }
    public TestBean(Long id, String name){
        this.id = id;
        this.name = name;
    }

    @Bean
    public TestBean testBean2(){
        return new TestBean(1L,"init name");
    }

    @Override
    public String toString(){
        return "TestBean{"+
                "id="+ id +
                ", name='"+ name + '\''
                + "}";
    }

    public long getId(){
        return id;
    }
    public void setId(long id){
       this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}
