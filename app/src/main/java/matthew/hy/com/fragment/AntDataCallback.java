package matthew.hy.com.fragment;

import java.util.Map;

/**
 * 获取数据回调接口.
 */

public abstract class AntDataCallback<JAVA_BEAN> {

    /**
     * 开始加载数据回调方法.
     *
     * @param tag       请求数据标记
     * @param uri       请求数据接口
     * @param parameter 请求数据参数
     * @param beanClass 解析之后的JavaBean
     */
    public abstract void onAntDataStart(int tag, String uri, Map<String, String> parameter, Class<JAVA_BEAN> beanClass);

    /**
     * 获取数据方法
     *
     * @param tag       请求数据标记
     * @param uri       请求数据接口
     * @param parameter 请求数据参数
     * @param beanClass 解析之后的JavaBean
     */
    public abstract void onAntDataGain(int tag, String uri, Map<String, String> parameter, Class<JAVA_BEAN> beanClass);

    /**
     * 数据获取成功
     *
     * @param tag       请求数据标记
     * @param result    请求数据内容
     * @param beanClass 解析之后的JavaBean
     */
    public abstract void onAntDataGainSuccess(int tag, String result, Class<JAVA_BEAN> beanClass);

    /**
     * 解析数据
     *
     * @param tag       请求数据标记
     * @param result    请求数据内容
     * @param beanClass 解析之后的JavaBean
     * @return <JAVA_BEAN></>解析之后的JavaBean
     */
    public abstract JAVA_BEAN onAntDataAnalyzy(int tag, String result, Class<JAVA_BEAN> beanClass);

    /**
     * 数据解析成功
     *
     * @param tag       请求数据标记
     * @param java_bean 解析数据内容
     */
    public abstract void onAntDataAnalyzeSuuccess(int tag, JAVA_BEAN java_bean);

    /**
     * 数据请求失败
     *
     * @param tag   请求数据标记
     * @param error 请求错误提示
     */
    public abstract void onAntDataError(int tag, String error);

    /**
     * 请求数据结束
     *
     * @param tag 请求数据标记
     */
    public abstract void onAntDataFinish(int tag);


}
