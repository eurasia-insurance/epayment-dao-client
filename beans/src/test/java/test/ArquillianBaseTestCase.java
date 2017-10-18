package test;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.runner.RunWith;

import com.lapsa.kkb.dao.jpaImpl.AEntityManagerDAO;

import tech.lapsa.lapsa.arquillian.archive.ArchiveBuilderFactory;

@RunWith(Arquillian.class)
public abstract class ArquillianBaseTestCase {

    @Deployment(testable = true)
    public static Archive<?> createDeploymentEAR() {
	return ArchiveBuilderFactory.newEarBuilder() //
		.withRuntimeDependencies() //
		.withModule(ArchiveBuilderFactory.newEjbBuilder() //
			.withManifestFolder() //
			.withPackageOf(AEntityManagerDAO.class) //
			.build() //
			.dumpingTo(System.out::println))
		.build() //
		.dumpingTo(System.out::println)
		.asEnterpriseArchive();
    }
}
