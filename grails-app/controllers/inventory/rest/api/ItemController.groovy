package inventory.rest.api


import grails.rest.*
import grails.converters.*
import org.springframework.http.HttpStatus

import javax.xml.bind.ValidationException

class ItemController {

    ItemService itemService

	static responseFormats = ['json', 'xml']

	
    def index(Integer max) {
        params.max = 100
        respond itemService.list(params), model: [itemCount: itemService.count()]
    }

    def save(Item item) {

        try {
            itemService.save(item)
        } catch (ValidationException e){
            respond item.errors
        }

        respond item, [status: HttpStatus.CREATED]
    }
}
