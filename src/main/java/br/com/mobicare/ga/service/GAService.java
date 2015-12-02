package br.com.mobicare.ga.service;

import br.com.mobicare.ga.adapter.GoogleAdapter;
import br.com.mobicare.ga.exception.HitException;
import br.com.mobicare.ga.request.HitRequest;
import br.com.mobicare.ga.response.GoogleResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GAService {

    @Autowired
    private GoogleAdapter googleAdapter;

    public GoogleResponseMessage hit(HitRequest hitRequest, boolean debug) throws HitException {

        hitRequest.validate();

        return googleAdapter.hit(hitRequest, debug);

    }

}
