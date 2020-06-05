package com.restaurant.dron.domain;

import com.restaurant.drone.domain.location.DroneLocation
import com.restaurant.shared.domain.Orientation
import com.restaurant.shared.generators.DroneGenerator
import spock.lang.Specification;


class DroneSpec  extends Specification {

    def 'The location of the drone should changes to the specific direction when the command is executed'() {
        given:"A drone"
            def drone = DroneGenerator.generate()
        and: "An expected drone location"
            def droneLocation = getExpectedDroneLocation()
        when:
            drone.moveForward()
        then:
            drone.location == droneLocation

    }

    def 'The orientation of the drone should changes to W(West) when the command is executed in the origin position'() {
        given:"A drone"
        def drone = DroneGenerator.generate()
        when:
        drone.turnLeft()
        then:
        drone.location.orientation == Orientation.W

    }

    def 'The orientation of the drone should changes to E(East) when the command is executed in the origin position'() {
        given:"A drone"
        def drone = DroneGenerator.generate()
        when:
        drone.turnRight()
        then:
        drone.location.orientation == Orientation.E

    }

    def 'Should return the output format for the initial point of the drone and direction'() {
        given:"A drone"
            def drone = DroneGenerator.generate()
        and:"An expected output"
            def expectedOutput = "(0,0) dirección North"
        when:
            String output = drone.outPutFormat
        then:
            expectedOutput == output

    }

    private static getExpectedDroneLocation() {

        return DroneLocation.builder()
                .x(0)
                .y(1)
                .orientation(Orientation.N)
                .build()
    }

}
