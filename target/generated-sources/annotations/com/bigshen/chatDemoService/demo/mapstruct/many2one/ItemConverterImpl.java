package com.bigshen.chatDemoService.demo.mapstruct.many2one;

import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-11-19T21:44:30+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_91 (Oracle Corporation)"
)
public class ItemConverterImpl implements ItemConverter {

    @Override
    public SkuDTO domain2dto(Item item, Sku sku) {
        if ( item == null && sku == null ) {
            return null;
        }

        SkuDTO skuDTO = new SkuDTO();

        if ( item != null ) {
            skuDTO.setItemId( item.getId() );
            skuDTO.setItemName( item.getTitle() );
        }
        if ( sku != null ) {
            skuDTO.setSkuPrice( sku.getPrice() );
            skuDTO.setSkuId( sku.getId() );
            skuDTO.setSkuCode( sku.getCode() );
        }

        return skuDTO;
    }
}
