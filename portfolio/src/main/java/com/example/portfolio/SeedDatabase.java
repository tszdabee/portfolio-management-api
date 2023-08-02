package com.example.portfolio;

import com.example.portfolio.model.Index;
import com.example.portfolio.model.Stock;
import com.example.portfolio.model.repository.StockRepository;
import com.example.portfolio.model.repository.IndexRepository;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SeedDatabase {

    @Autowired
    private StockRepository repository;

    @Autowired
    private IndexRepository indexRepo;

        @PostConstruct
        public void init() {
            repository.save( new Stock("AAPL" ,"Apple Inc.", 150.50, -0.33, 100.0, "Technology") );
            repository.save( new Stock("GOOGL" ,"Alphabet Inc.", 2800.20, 0.18, 50.0, "Technology") );
            repository.save( new Stock("AMZN" ,"Amazon.com Inc.", 3250.75, -0.48, 75.0, "Technology") );
            repository.save( new Stock("MSFT" ,"Microsoft Corporation", 290.40, -0.21, 120.0, "Technology") );
            repository.save( new Stock("TSLA" ,"Tesla", 700.00, 0.38, 30.0, "Automotive") );
            repository.save( new Stock("JPM" ,"JPMorgan Chase & Co.", 150.80, 0.17, 90.0, "Finance") );
            repository.save( new Stock("NVDA" ,"NVIDIA Corporation", 220.30, -0.10, 65.0, "Technology") );
            repository.save( new Stock("WMT" ,"Walmart Inc.", 140.10, 0.32, 110.0, "Retail") );
            repository.save( new Stock("JNJ" ,"Johnson & Johnson", 170.25, 0.43, 85.0, "Healthcare") );
            repository.save( new Stock("BAC" ,"Bank of America Corporation", 40.50, -0.16, 150.0, "Finance") );
            repository.save( new Stock("XOM" ,"Exxon Mobil Corporation", 60.70, 0.07, 70.0, "Energy") );
            repository.save( new Stock("PFE" ,"Pfizer Inc.", 45.80, 0.21, 200.0, "Healthcare") );
            repository.save( new Stock("HD" ,"The Home Depot", 350.90, -0.17, 40.0, "Retail") );
            repository.save( new Stock("V" ,"Visa Inc.", 250.60, -0.02, 55.0, "Finance") );
            repository.save( new Stock("PG" ,"Procter & Gamble Co.", 135.00, -0.13, 100.0, "Consumer Goods") );
            repository.save( new Stock("MA" ,"Mastercard Incorporated", 390.10, 0.12, 25.0, "Finance") );
            repository.save( new Stock("INTC" ,"Intel Corporation", 55.25, -0.32, 80.0, "Technology") );
            repository.save( new Stock("CRM" ,"Salesforce", 280.00, 0.32, 45.0, "Technology") );
            repository.save( new Stock("VZ" ,"Verizon Communications Inc.", 55.50, 0.41, 70.0, "Telecommunications") );
            repository.save( new Stock("KO" ,"The Coca-Cola Company", 55.75, -0.05, 120.0, "Consumer Goods") );

            indexRepo.save( new Index("GSPTSE","S&P/TSX Composite",20176.27,-1.74,100.00,"Sell") );
            indexRepo.save( new Index("SPTSE","S&P/TSX 60",1209.70,-1.78,25.00,"Strong Sell") );
            indexRepo.save( new Index("DJI","Dow Jones Industrial Average",35384.78,-0.69,50.00,"Strong Buy") );
            indexRepo.save( new Index("US500","S&P 500",4516.38,-1.32,0.00,"Neutral") );
            indexRepo.save( new Index("IXIC","NASDAQ Composite",13954.39,-2.31,25.00,"Sell") );
            indexRepo.save( new Index("US2000","Russell 2000",1959.60,-1.73,0.00,"Strong Buy") );
            indexRepo.save( new Index("VIX","CBOE Volatility Index",16.14,15.87,0.00,"Buy") );
            indexRepo.save( new Index("BVSP","Bovespa",120383.00,-0.71,50.00,"Buy") );
            indexRepo.save( new Index("MXX","S&P/BMV IPC",53554.13,-1.21,78.00,"Strong Sell") );
            indexRepo.save( new Index("DE40","DAX",16020.02,-1.36,35.00,"Sell") );
            indexRepo.save( new Index("UK100","FTSE 100",7561.23,-1.37,100.00,"Strong Sell") );
            indexRepo.save( new Index("FCHI","CAC 40",7312.84,-1.26,120.00,"Strong Sell") );
            indexRepo.save( new Index("STOXX50","Euro Stoxx 50",4336.85,-1.60,50.00,"Sell") );
            indexRepo.save( new Index("AEX","AEX",775.03,-1.41,25.00,"Neutral") );
            indexRepo.save( new Index("ES35","IBEX 35",9328.70,-1.83,0.00,"Strong Sell") );
            indexRepo.save( new Index("IT40","FTSE MIB",28981.00,-1.28,88.00,"Buy") );
            indexRepo.save( new Index("SWI20","SMI",11219.50,-0.79,100.00,"Neutral") );
            indexRepo.save( new Index("PSI20","PSI",5978.99,-1.67,110.00,"Strong Sell") );
            indexRepo.save( new Index("BFX","BEL 20",3719.80,-1.21,50.00,"Neutral") );
            indexRepo.save( new Index("ATX","ATX",3181.74,-1.43,60.00,"Sell") );
            indexRepo.save( new Index("OMXS30","OMX Stockholm 30",2222.74,-0.78,20.00,"Strong Sell") );
            indexRepo.save( new Index("IMOEX","MOEX Russia",3106.46,0.41,0.00,"Strong Buy") );
            indexRepo.save( new Index("IRTS","RTSI",1040.15,-1.48,120.00,"Strong Buy") );
            indexRepo.save( new Index("WIG20","WIG20",2142.82,-2.10,130.00,"Buy") );
            indexRepo.save( new Index("BUX","Budapest SE",53823.23,0.84,30.00,"Strong Buy") );
            indexRepo.save( new Index("XU100","BIST 100",7258.54,1.26,70.00,"Strong Buy") );
            indexRepo.save( new Index("TA35","TA 35",1862.35,0.04,25.00,"Buy") );
            indexRepo.save( new Index("TASI","Tadawul All Share",11478.28,-1.36,50.00,"Strong Sell") );
            indexRepo.save( new Index("JP225","Nikkei 225",32707.50,-2.27,100.00,"Buy") );
            indexRepo.save( new Index("AXJO","S&P/ASX 200",354.60,-1.29,25.00,"Strong Buy") );
            indexRepo.save( new Index("SSEC","Shanghai Composite",3261.69,-0.89,40.00,"Strong Buy") );
            indexRepo.save( new Index("SZI","SZSE Component",11104.16,-0.35,80.00,"Strong Buy") );
            indexRepo.save( new Index("FTXIN9","FTSE China A50",13115.05,-1.04,20.00,"Strong Buy") );
            indexRepo.save( new Index("DJSH","Dow Jones Shanghai",460.88,-0.67,0.00,"Strong Buy") );
            indexRepo.save( new Index("HK50","Hang Seng",19514.00,-2.48,0.00,"Strong Buy") );
            indexRepo.save( new Index("TWII","Taiwan Weighted",17212.87,0.39,30.00,"Buy") );
            indexRepo.save( new Index("KS11","KOSPI",2616.47,-1.90,80.00,"Strong Buy") );
            indexRepo.save( new Index("JKSE","Jakarta Stock Exchange Composite Index",6854.51,-0.46,60.00,"Neutral") );
            indexRepo.save( new Index("NSEI","Nifty 50",19526.55,-1.05,30.00,"Neutral") );
            indexRepo.save( new Index("BSESN","BSE Sensex 30",65782.78,-1.02,50.00,"Neutral") );
            indexRepo.save( new Index("VNI30","VN 30",1221.32,-0.07,100.00,"Strong Buy") );
        }

}