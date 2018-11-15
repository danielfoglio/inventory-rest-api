package inventory.rest.api

import grails.testing.web.controllers.ControllerUnitTest
import org.springframework.http.HttpStatus
import spock.lang.Specification

class ItemControllerSpec extends Specification implements ControllerUnitTest<ItemController> {

    def setupSpec() {
    }

    def cleanup() {
    }

    void "test index returns empty list when no items"() {
        given:
        controller.itemService = Mock(ItemService) {
            1 * list(_) >> []
            1 * count() >> 0
        }

        when: "we call index()"
        controller.index()

        then: "response is empty list"
        response.text == '[]'
    }

    void "test save action saves item"(){

        given:
        controller.itemService = Mock(ItemService){
            1 * save(_ as Item)
        }

        when:
        request.method = 'POST'
        Item item = new Item(name: "pencil")
        item.id = 1
        controller.save(item)

        then:
        response.status == HttpStatus.CREATED.value()


    }


}