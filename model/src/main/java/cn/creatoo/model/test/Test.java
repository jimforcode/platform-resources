package cn.creatoo.model.test;

public class Test {

    public Test() {
    }

    public Test(String id, String name, Integer version, String context) {
        this.id = id;
        this.name = name;
        this.version = version;
        this.context = context;
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column test.id
     *
     * @mbggenerated Wed Aug 09 13:25:35 CST 2017
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column test.name
     *
     * @mbggenerated Wed Aug 09 13:25:35 CST 2017
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column test.version
     *
     * @mbggenerated Wed Aug 09 13:25:35 CST 2017
     */
    private Integer version;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column test.context
     *
     * @mbggenerated Wed Aug 09 13:25:35 CST 2017
     */
    private String context;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test.id
     *
     * @return the value of test.id
     *
     * @mbggenerated Wed Aug 09 13:25:35 CST 2017
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test.id
     *
     * @param id the value for test.id
     *
     * @mbggenerated Wed Aug 09 13:25:35 CST 2017
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test.name
     *
     * @return the value of test.name
     *
     * @mbggenerated Wed Aug 09 13:25:35 CST 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test.name
     *
     * @param name the value for test.name
     *
     * @mbggenerated Wed Aug 09 13:25:35 CST 2017
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test.version
     *
     * @return the value of test.version
     *
     * @mbggenerated Wed Aug 09 13:25:35 CST 2017
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test.version
     *
     * @param version the value for test.version
     *
     * @mbggenerated Wed Aug 09 13:25:35 CST 2017
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test.context
     *
     * @return the value of test.context
     *
     * @mbggenerated Wed Aug 09 13:25:35 CST 2017
     */
    public String getContext() {
        return context;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test.context
     *
     * @param context the value for test.context
     *
     * @mbggenerated Wed Aug 09 13:25:35 CST 2017
     */
    public void setContext(String context) {
        this.context = context;
    }


    @Override
    public String toString() {
        return "Test{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", version=" + version +
                ", context='" + context + '\'' +
                '}';
    }
}