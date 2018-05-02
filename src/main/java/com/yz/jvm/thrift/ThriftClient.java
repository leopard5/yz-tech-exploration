package com.yz.jvm.thrift;

import com.alibaba.fastjson.JSON;
import com.yz.jvm.serialization.thrift.Person;
import com.yz.jvm.serialization.thrift.PersonService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class ThriftClient {
    public static void main(String[] args) {
        TTransport transport = null;
        try {
            transport = new TFramedTransport(
                    new TSocket("localhost", 8899), 900);
            TProtocol protocol = new TCompactProtocol(transport);
            PersonService.Client client = new PersonService.Client(protocol);

            try {
                transport.open();


                Person person = client.getPersonByUserName("harry");
                System.out.println("client receive data=" + JSON.toJSONString(person));

                Person person1 = new Person();
                person1.setMarried(true);
                person1.setUsername("peter");
                person1.setAge(35);

                client.savePerson(person1);
            } catch (TException e) {
                e.printStackTrace();
            } finally {
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (transport != null) {
                transport.close();
            }
        }
    }
}
