var SJ_List = ['000020',
'000040',
'000050',
'000060',
'000070',
'000080',
'000100',
'000120',
'000140',
'000150',
'000180',
'000210'
];

var cheerio = require('cheerio');
var request = require('request');

Result = {
    'PER' : ''
}

Result2 = {
    'PER' : '',
    'MARKETCAP'  : ''
}

function getData() {
    var html = "https://finance.naver.com/item/sise.naver?code=000020";
    request(html, function(err, res, body) {
        const $ = cheerio.load(body);
        const bodyList = $(".type2 tbody tr:nth-of-type(10) td:nth-of-type(1)").map(function(i, element) {
            Result['PER'] = String($(element).find('span').text().trim());
            console.log(Result);
        });
    });
}

function getData2() {
    var html = "https://finance.naver.com/item/sise.naver?code=000020";
    request(html, function(err, res, body) {
        const $ = cheerio.load(body);
        const bodyList_PER = $(".type2 tbody tr:nth-of-type(10) td:nth-of-type(1)");
        const bodyList_MARKETCAP = $(".type2 tbody tr:nth-of-type(12) td:nth-of-type(1)");
        Result2['PER'] = String($(bodyList_PER).find('span').text().trim());
        Result2['MARKETCAP'] = String($(bodyList_MARKETCAP).find('span:nth-of-type(1)').text().trim());
        console.log(Result2);
    });
}

function getData3() {
    for(var i = 0; i < SJ_List.length; i++) {
        var html = "https://finance.naver.com/item/sise.naver?code=";
        html += SJ_List[i];
        request(html, function(err, res, body) {
            const $ = cheerio.load(body);
            const bodyList_PER = $(".type2 tbody tr:nth-of-type(10) td:nth-of-type(1)");
            const bodyList_MARKETCAP = $(".type2 tbody tr:nth-of-type(12) td:nth-of-type(1)");
            Result2['PER'] = String($(bodyList_PER).find('span').text().trim());
            //Result2['MARKETCAP'] = String($(bodyList_MARKETCAP).text().trim());
            //Result2['MARKETCAP'] = String($(bodyList_MARKETCAP).find('span:nth-of-type(1)').text());
            
            Result2['MARKETCAP'] = String($(bodyList_MARKETCAP).text()).split('���');
            //CnvStringToInt(Result2['MARKETCAP']);
            
            var test = Result2['MARKETCAP'][0];
            console.log(test);
            console.log(Result2);
        });
    }
}
alert("on!");
getData3();