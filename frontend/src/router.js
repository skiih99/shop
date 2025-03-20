
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderServiceOrderManager from "./components/listers/OrderServiceOrderCards"
import OrderServiceOrderDetail from "./components/listers/OrderServiceOrderDetail"

import DeliveryServiceDeliveryManager from "./components/listers/DeliveryServiceDeliveryCards"
import DeliveryServiceDeliveryDetail from "./components/listers/DeliveryServiceDeliveryDetail"
import DeliveryServiceInventoryManager from "./components/listers/DeliveryServiceInventoryCards"
import DeliveryServiceInventoryDetail from "./components/listers/DeliveryServiceInventoryDetail"


import MyViewView from "./components/MyViewView"
import MyViewViewDetail from "./components/MyViewViewDetail"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/orderServices/orders',
                name: 'OrderServiceOrderManager',
                component: OrderServiceOrderManager
            },
            {
                path: '/orderServices/orders/:id',
                name: 'OrderServiceOrderDetail',
                component: OrderServiceOrderDetail
            },

            {
                path: '/deliveryServices/deliveries',
                name: 'DeliveryServiceDeliveryManager',
                component: DeliveryServiceDeliveryManager
            },
            {
                path: '/deliveryServices/deliveries/:id',
                name: 'DeliveryServiceDeliveryDetail',
                component: DeliveryServiceDeliveryDetail
            },
            {
                path: '/deliveryServices/inventories',
                name: 'DeliveryServiceInventoryManager',
                component: DeliveryServiceInventoryManager
            },
            {
                path: '/deliveryServices/inventories/:id',
                name: 'DeliveryServiceInventoryDetail',
                component: DeliveryServiceInventoryDetail
            },


            {
                path: '/dashboardServices/myViews',
                name: 'MyViewView',
                component: MyViewView
            },
            {
                path: '/dashboardServices/myViews/:id',
                name: 'MyViewViewDetail',
                component: MyViewViewDetail
            },


    ]
})
