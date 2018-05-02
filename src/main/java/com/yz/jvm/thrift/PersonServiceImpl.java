package com.yz.jvm.thrift;

import com.alibaba.fastjson.JSON;
import com.yz.jvm.serialization.thrift.Person;
import com.yz.jvm.serialization.thrift.PersonService;
import org.apache.thrift.TException;

public class PersonServiceImpl implements PersonService.Iface {
    @Override
    public Person getPersonByUserName(String username) throws TException {
        System.out.println("getPersonByUserName client param=" + username);

        Person person = new Person();
        person.setAge(11);
        person.setUsername(username);
        person.setMarried(true);
        return person;
    }

    @Override
    public void savePerson(Person person) throws TException {
        System.out.println("savePerson client param=" + JSON.toJSONString(person));
    }
}
