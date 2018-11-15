package inventory.rest.api

import grails.gorm.services.Service

@Service(Item)
interface ItemService {

    Item get(Serializable id)

    List<Item> list(Map args)

    Long count()

    Item save(Item item)
}
