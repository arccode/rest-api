/**
 * product.js : 商品操作
 *
 * @author arccode
 * @since 2015-04-16 11:17
 */
$(function () {

    //使用superagent.js 执行AJAX请求
    var req = window.superagent;

    /**
     * 使用vue.js 执行ViewModel数据双向绑定
     *
     * el: 绑定的作用域
     * events: vue事件, 可使用$emit触发
     * methods: dom事件
     *
     * @type {Vue}
     */
    var vm = new Vue({
        el: '#root',
        data: {
            method: 'POST',
            urls: null,
            url: null,
            request: null,
            response: null
        },
        ready: function () {

            this.$emit('init');
        },
        events: {

            submit: function() {

                if(vm.method == 'GET') {

                    vm.request = null;
                    vm.response = null;

                    req
                        .get(vm.url)
                        .end(function (err, res) {
                            vm.response = res.text;
                        })
                } else if(vm.method == 'POST') {

                    vm.request = null;
                    vm.response = null;

                    var product = {name: 'Apple Watch SPORT', description: 'Sport 系列的表壳材料为轻巧的银色及深空灰色阳极氧化铝金属，强化 Ion-X 玻璃材质为显示屏提供保护。搭配高性能 Fluoroelastomer 表带，共有 5 款缤纷色彩。'}
                    vm.request = JSON.stringify(product);
                    req
                        .post(vm.url)
                        .set('Content-Type', 'application/json')
                        .send(JSON.stringify(product))
                        .end(function (err, res) {
                            vm.response = res.text;
                        })
                } else if(vm.method == 'PUT') {

                    vm.request = null;
                    vm.response = null;

                    var product = {name: 'iPhone 6', description: '此次苹果发布会发布了iPhone 6与iPhone 6 Plus，搭载iOS 8，尺寸分别是4.7和5.5英寸。外观设计不再棱角分明，表层玻璃边有一个弧度向下延伸，与阳极氧化铝金属机身边框衔接。机身背部采用三段式设计。机身更薄，续航能力更强。'}
                    vm.request = JSON.stringify(product);
                    req
                        .put(vm.url)
                        .set('Content-Type', 'application/json')
                        .send(JSON.stringify(product))
                        .end(function (err, res) {
                            vm.response = res.text;
                        })
                } else if(vm.method == 'DELETE') {

                    vm.request = null;
                    vm.response = null;

                    req
                        .del(vm.url)
                        .end(function (err, res) {
                            vm.response = res.text;
                        })
                }

            },
            // 初始化数据
            init: function() {
                req
                    .get('/rest/api/selects')
                    .end(function (res) {
                        var obj = JSON.parse(res.text);
                        vm.urls = obj;
                        vm.url = obj[0].value;
                    })
            }
        },
        methods: {
            onSubmit: function() {
                this.$emit('submit');
            }
        }
    })

})

