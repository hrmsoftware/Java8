package se.hrmsoftware.optionals;

import java.util.Optional;

import static se.hrmsoftware.model.OptionalModel.*;

public class Optionals {

	public static final String SYS_PROP = "some.property";

	public static int readSystemProperty(int defaultValue) {
		// TODO:
		// Get a property configuration value
		return Optional.ofNullable(System.getProperty(SYS_PROP))
				.map(Integer::parseInt)
				.orElse(defaultValue);
	}

	public static String addressOfStandinProjectLeader(Project project) {
		// TODO:
		// Given a project, return the name of the street where the standin project leader lives. If the street is missing of the
		// standin - return the name of the street of the primary project leader. If that is missing, return "N/A".
		return Optional.ofNullable(project.getStandIn())
				.map(ProjectLeader::getAddress)
				.map(Address::getStreet)
				.orElse(Optional.ofNullable(project.getProjectLeader())
						.map(ProjectLeader::getAddress)
						.map(Address::getStreet).orElse("N/A"));
	}
}
