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


getData2();