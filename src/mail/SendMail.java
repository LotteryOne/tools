package one;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;
import java.io.File;
import java.io.FileInputStream;

import java.util.Date;
import java.util.Properties;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class SendMail {


    //private static ExecutorService executor = Executors.newFixedThreadPool(20);


    public static void main(String[] args) throws Exception {

        t1();


    }


    static class Job implements Runnable {

        private Transport transport;

        private MimeMessage mimeMessage;

        private String path;

        public Job(Transport transport, MimeMessage mimeMessage, String path) {
            this.transport = transport;
            this.mimeMessage = mimeMessage;
            this.path = path;
        }

        @Override
        public void run() {

            try {
                transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
            } catch (MessagingException e) {
                e.printStackTrace();
                System.err.println("send error:" + this.path);
                return;
            }

            System.out.println(this.path + " send succ");
        }
    }

    private static void t1() throws Exception {
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/mail.properties"));

        Session session = Session.getDefaultInstance(prop);

//        session.setDebug(true);


        String localPath = prop.getProperty("localPath");
        File file = new File(localPath);
//
        String[] files = file.list();
//
//        for (String fil : files) {
//            System.out.println(localPath + "/" + fil);
// //            Job jb = new Job(transport, message, fil);
////            executor.execute(jb);
//            }


        int a = 0;

        while (true) {

            files = file.list();
            if (files == null || files.length <= 0) break;
            a++;
            if (a > 1000) break;
            for (String fil : files) {
                Transport transport = session.getTransport();

                transport.connect(prop.getProperty("account"), prop.getProperty("passwd"));
                File file1 = new File(localPath + "/" + fil);
                try {
                    String fid = localPath + "/" + fil;

                    MimeMessage message = createMimeMessage(session, prop.getProperty("account"), prop.getProperty("receive"), fid);
                    transport.sendMessage(message, message.getAllRecipients());
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("send error:"+e.getCause());

                    continue;

                }

                file1.delete();
                System.out.println("file1:"+file1.exists());

                System.out.println(fil + " send succ");
                transport.close();
                System.gc();
            }


        }



    }

    public static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail, String file) throws Exception {
        // 1. 创建一封邮件
        MimeMessage message = new MimeMessage(session);

        // 2. From: 发件人（昵称有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改昵称）
        message.setFrom(new InternetAddress(sendMail, "我自己", "UTF-8"));

        // 3. To: 收件人（可以增加多个收件人、抄送、密送）
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "我自己", "UTF-8"));

        // 4. Subject: 邮件主题（标题有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改标题）
        message.setSubject("批量发送", "UTF-8");

        // 5. Content: 邮件正文（可以使用html标签）（内容有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改发送内容）
        message.setContent("做个测试", "text/html;charset=UTF-8");

        // 6. 设置发件时间
        message.setSentDate(new Date());

        message.addHeader("X-Mailer", "Microsoft Outlook Express 6.00.2900.2869");

//
//        // 9. 创建附件“节点”
        MimeBodyPart attachment = new MimeBodyPart();
        DataHandler dh2 = new DataHandler(new FileDataSource(file));  // 读取本地文件
        attachment.setDataHandler(dh2);                                             // 将附件数据添加到“节点”
        attachment.setFileName(MimeUtility.encodeText(dh2.getName()));              // 设置附件的文件名（需要

        // 10. 设置（文本+图片）和 附件 的关系（合成一个大的混合“节点” / Multipart ）
        MimeMultipart mm = new MimeMultipart();
        mm.addBodyPart(attachment);
        message.setContent(mm);

        // 7. 保存设置
        message.saveChanges();

        return message;
    }


}
