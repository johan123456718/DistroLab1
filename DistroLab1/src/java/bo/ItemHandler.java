/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import ui.ItemInfo;

/**
 *
 * @author Johan Challita
 * 
 *  * Class that handles calls from UI layer to BO layer, related to items 
 */
public class ItemHandler {

    /**
     *
     * Gives information for all items found
     * @return Collection of ItemInfo
     */
    public static Collection<ItemInfo> getAllItems() {
        Collection c = Item.getAllItems();
        ArrayList<ItemInfo> items = new ArrayList<>();

        for (Iterator it = c.iterator(); it.hasNext();) {
            Item item = (Item) it.next();
            items.add(new ItemInfo(item.getName(), item.getDescr()));
        }
        return items;
    }
}
