package kz.aa.shop.onlineShop.service.impl;

import kz.aa.shop.onlineShop.model.property.PropertyCap;
import kz.aa.shop.onlineShop.service.PropertyCapService;
import kz.aa.shop.onlineShop.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PropertyCapServiceImpl extends BaseServiceImpl<PropertyCap, Long> implements PropertyCapService {
}