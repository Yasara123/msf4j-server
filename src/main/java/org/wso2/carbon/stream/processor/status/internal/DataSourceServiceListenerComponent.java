package org.wso2.carbon.stream.processor.status.internal;

import com.zaxxer.hikari.HikariDataSource;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.jndi.JNDIContextManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wso2.carbon.datasource.core.api.DataSourceManagementService;
import org.wso2.carbon.datasource.core.api.DataSourceService;
import org.wso2.carbon.datasource.core.beans.DataSourceMetadata;
import org.wso2.carbon.datasource.core.exception.DataSourceException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Example class.
 */
@Component(
        name = "org.wso2.carbon.kernel.datasource.sample",
        immediate = true
)
public class DataSourceServiceListenerComponent {

    private static final Logger logger = LoggerFactory.getLogger(DataSourceServiceListenerComponent.class);

    @Activate
    protected void start(BundleContext bundleContext) {
    }

    @Reference(
            name = "org.wso2.carbon.datasource.DataSourceService",
            service = DataSourceService.class,
            cardinality = ReferenceCardinality.AT_LEAST_ONE,
            policy = ReferencePolicy.DYNAMIC,
            unbind = "unregisterDataSourceService"
    )
    protected void onDataSourceServiceReady(DataSourceService service) {
//        ConfigProvider configProvider = ConfigProviderFactory.getConfigProvider(Paths.get(System.getProperty
//                ("carbon.home"), "conf", "wso2.datasource.yaml"), secureVault);
//        DataSourcesConfiguration dataSourcesConfiguration = configProvider.getConfigurationObject
//                (DataSourcesConfiguration.class);
        Connection connection = null;
        try {
            HikariDataSource dsObject = (HikariDataSource) service.getDataSource("WSO2_METRICS_DB");
            //HikariRDBMSDataSource
            connection = dsObject.getConnection();
            Statement stmt = null;
            ResultSet rs;
            try {
                String query = "select * from METRIC_GAUGE";
                // create the java statement
                stmt = connection.createStatement();
                // execute the query, and get a java resultset
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    String name = rs.getString("NAME");
                    String value = rs.getString("VALUE");
                    logger.info("---->> " + name + ":" + value);
                }
                rs.close();
                stmt.close();
            } catch (SQLException e) {
                assert stmt != null;
                stmt.close();
              logger.error("Error");
            }
            logger.info("Database Major Version {}", connection.getMetaData().getDatabaseMajorVersion());
            //From connection do the required CRUD operation
        } catch (DataSourceException e) {
            logger.error("error occurred while fetching the data source.", e);
        } catch (SQLException e) {
            logger.error("error occurred while fetching the connection.", e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    logger.error("error occurred while closing the connection.", e);
                }
            }
        }
    }

    @Reference(
            name = "org.wso2.carbon.datasource.DataSourceManagementService",
            service = DataSourceManagementService.class,
            cardinality = ReferenceCardinality.AT_LEAST_ONE,
            policy = ReferencePolicy.DYNAMIC,
            unbind = "unregisterDataSourceManagementService"
    )
    protected void onDataSourceManagementServiceReady(DataSourceManagementService service) {
        logger.info("Sample bundle register method fired");
        try {
            DataSourceMetadata metadata = service.getDataSource("WSO2_METRICS_DB");
            logger.info(metadata.getName());
            //You can perform your functionalities by using the injected service.
        } catch (DataSourceException e) {
            logger.error("Error occurred while fetching the data sources", e);
        }
    }


//    @Reference(
//            name = "org.wso2.carbon.datasource.jndi",
//            service = JNDIContextManager.class,
//            cardinality = ReferenceCardinality.AT_LEAST_ONE,
//            policy = ReferencePolicy.DYNAMIC,
//            unbind = "onJNDIUnregister"
//    )
//    protected void onJNDIReady(JNDIContextManager service) {
//
//        try {
//            Context ctx = service.newInitialContext();
//            Object obj = ctx.lookup("java:comp/env/jdbc/WSO2_METRICS_DB/test");
//            logger.info("Fetched data source: " + obj.toString());
//            //Cast the object to required DataSource type and perform crud operation.
//        } catch (NamingException e) {
//            logger.info("Error occurred while jndi lookup", e);
//        }
//    }


    protected void onJNDIUnregister(JNDIContextManager jndiContextManager) {
        logger.info("Unregistering data sources sample");
    }

    protected void unregisterDataSourceService(DataSourceService dataSourceService) {
        logger.info("Unregistering data sources sample");
    }

    protected void unregisterDataSourceManagementService(DataSourceManagementService dataSourceManagementService) {
        logger.info("Unregistering data sources sample");
    }
}
