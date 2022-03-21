package com.redingmatecrew.api.domain.bike.oiling;

import com.redingmatecrew.api.domain.bike.Bike;

public interface OilingRepository {
    Oiling save(Oiling oiling);
}
