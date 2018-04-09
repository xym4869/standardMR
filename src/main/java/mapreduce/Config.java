package mapreduce;
//程序的部分文件路径
public class Config {
    //Hadoop的输入输出路径
    public static final String HDFSINPUTPATH = "hdfs://hadoop:9000/minipre";
    public static final String HDFSOUTPUTPATH = "hdfs://hadoop:9000/minipre_res";

    //UserAgent文件的路径和分隔符
    public static final String UAPATH = "UserAgent.csv";
    public static final String UASEPARATOR = ",";
    //DomainKeywords文件的路径和分隔符
    public static final String DOMAINKEYWORDSPATH = "DomainKeywordsList.csv";
    public static final String DOMAINKEYWORDSSEPARATOR = ",";
}
