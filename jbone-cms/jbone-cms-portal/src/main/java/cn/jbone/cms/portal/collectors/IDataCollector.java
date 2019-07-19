package cn.jbone.cms.portal.collectors;

public interface IDataCollector<E extends DataCollectorContext> {
    void collect(E context);
}
