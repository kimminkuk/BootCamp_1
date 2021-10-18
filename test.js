var cheerio = require('cheerio');
var request = require('request');

Result = {
    'date':'',
    'the_basic_rate': '',
    'buy':'',
    'sell':''
}

var TESTUPDATE = ['0','1'];

function getData() {
    var html = "https://finance.naver.com/marketindex/exchangeDailyQuote.nhn";
    request(html, function(err,res,body) {
        const $ = cheerio.load(body);
        const bodyList = $(".tbl_exchange tbody tr").map(function(i, element) {
            Result['date'] = String($(element).find('td:nth-of-type(1)').text());
            Result['the_basic_rate'] = String($(element).find('td:nth-of-type(2)').text());
            Result['buy'] = String($(element).find('td:nth-of-type(4)').text());
            Result['sell'] = String($(element).find('td:nth-of-type(5)').text());

            console.log(Result);
        });
    });
}

var t = getData();
console.log(t);