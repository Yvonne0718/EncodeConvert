import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;

public class Convert
{
	/**
	 * ���ƶ�Ŀ¼�µ�����JavaԴ�ļ��ı����ʽ��GBK�޸�ΪUTF-8
	 */
	public static final String[] javastr = { "java" };

	public static void GBKtoUTF8(String GBKsrc, String toUTF8src) throws IOException
	{
		// GBK�����ʽԴ��·��
		String srcDirPath = GBKsrc;
		// תΪUTF-8�����ʽԴ��·��
		String utf8DirPath = toUTF8src;

		// ��ȡ����java�ļ�
		Collection<File> javaGbkFileCol = FileUtils.listFiles(new File(srcDirPath), javastr, true);

		for (Iterator<File> iterator = javaGbkFileCol.iterator(); iterator.hasNext();)
		{
			File javaGbkFile = iterator.next();
			// UTF8��ʽ�ļ�·��
			String utf8FilePath = utf8DirPath
					+ javaGbkFile.getAbsolutePath().substring(srcDirPath.length());

			// ʹ��GBK��ȡ���ݣ�Ȼ����UTF-8д������
			FileUtils.writeLines(new File(utf8FilePath), "UTF-8",
					FileUtils.readLines(javaGbkFile, "GBK"));
			System.out.println("ת����ɣ�");
		}
	}

	/**
	 * ���ƶ�Ŀ¼�µ�����JavaԴ�ļ��ı����ʽ��UTF-8�޸�ΪGBK
	 */
	public static void UTF8toGBK(String UTF8src, String toGBKsrc) throws IOException
	{
		// UTF-8�����ʽԴ��·��
		String srcDirPath = UTF8src;
		// תΪGBK�����ʽԴ��·��
		String gbkDirPath = toGBKsrc;

		// ��ȡ����java�ļ�
		Collection<File> javaUtf8FileCol = FileUtils.listFiles(new File(srcDirPath), javastr, true);

		for (Iterator<File> iterator = javaUtf8FileCol.iterator(); iterator.hasNext();)
		{
			File javaUtf8File = iterator.next();
			// UTF8��ʽ�ļ�·��
			String GBK8FilePath = gbkDirPath
					+ javaUtf8File.getAbsolutePath().substring(srcDirPath.length());

			// ʹ��GBK��ȡ���ݣ�Ȼ����UTF-8д������
			FileUtils.writeLines(new File(GBK8FilePath), "GBK",
					FileUtils.readLines(javaUtf8File, "UTF-8"));
			System.out.println("ת����ɣ�");
		}
	}
}
