package one;

import javax.mail.*;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import javax.mail.search.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class ReceiveMail {
    public static void main(String[] args) throws Exception {
        t2();
    }

    private static void t2() throws Exception {


        Properties prop = new Properties();
        prop.load(new FileInputStream("src/receive.properties"));

        String procotol = prop.getProperty("mail.transport.protocol");

        Session session = Session.getDefaultInstance(prop);

        //session.setDebug(true);

        Store store = session.getStore(procotol);

        store.connect(prop.getProperty("mail.smtp.host"), prop.getProperty("account"), prop.getProperty("passwd"));

        Folder floder = store.getFolder("INBOX");

        floder.open(Folder.READ_ONLY);



        Message msg = floder.getMessage(287);
        System.out.println("======all=======\n"+ floder.getMessageCount());
        System.out.println("======all=======");
        Date dt = msg.getSentDate();

        System.out.println("======all=======");
        System.out.println(msg.getSubject());
        Multipart part = (Multipart) msg.getContent();
        System.out.println("------------------");
        for (int i=0;i<part.getCount();i++){

            BodyPart body = part.getBodyPart(i);
            System.out.println(body.getDisposition());

            if(body.getFileName()!=null){
                InputStream ins = body.getInputStream();

                save(prop.getProperty("save")+ MimeUtility.decodeText(body.getFileName()),ins);


            }else{
                MimeMultipart pc = (MimeMultipart) body.getContent();

                for (int j=0;j<pc.getCount();j++){
                    System.out.println(pc.getBodyPart(j).getContent());
                }


            }


            System.out.println(body.getFileName());
            System.out.println(body.getContentType());
            System.out.println("------------------");

//            System.out.println(body.isMimeType("multipart/*"));
//             if(body.isMimeType("multipart/*")){
//                 System.out.println(body.getFileName());
//
//             }

        }

        //SearchTerm[] condition = new SearchTerm[]{};

      //  SentDateTerm sent = new SentDateTerm(ComparisonTerm. new SimpleDateFormat("yyyy-MM-dd").parse("2017-09-21"));
//        ReceivedDateTerm receiveDate = new ReceivedDateTerm(ComparisonTerm.EQ,
//               );
        //SearchTerm st = new AndTerm(condition);
//
//        DateTerm dateTerm=new DateTerm() {
//            @Override
//            public boolean match(Message message) {
//
//                message.getSentDate();
//
//
//
//                return false;
//            }
//        };
//
//
////        SearchTerm st = new AndTerm(new FromStringTerm("ztokefu@zto.cn"),sent);
//        Message[] messages = floder.search(sent);
//        System.out.println("===================");
//        System.out.println(messages.length);
//        for (Message msg : messages) {
//            String sub = msg.getSubject();
//            System.out.println(sub);
//        }

        floder.close(false);
        store.close();


    }

    private static void save(String s, InputStream ins) {

        BufferedInputStream bins=new BufferedInputStream(ins);

        try {
            FileOutputStream fos=new FileOutputStream(new File(s));

            byte[] tmp=new byte[1024];

            int len=0;

            while((len=bins.read(tmp))!=-1){
                fos.write(tmp,0,len);
            }
            fos.flush();


            if(fos!=null)fos.close();


            if(ins!=null){
                ins.close();
            }


        } catch ( Exception e) {
            e.printStackTrace();
        }



    }
}
