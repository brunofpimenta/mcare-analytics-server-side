package br.com.mobicare.ga.service;

import br.com.mobicare.ga.adapter.GoogleAdapter;
import br.com.mobicare.ga.exception.HitException;
import br.com.mobicare.ga.request.HitRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GAService {

    @Autowired
    private GoogleAdapter googleAdapter;

    public void hit(HitRequest hitRequest) throws HitException {

        hitRequest.validate();

        googleAdapter.hit(hitRequest, false);

    }

    public String hitDebug(HitRequest hitRequest) throws HitException {

        hitRequest.validate();

        return googleAdapter.hit(hitRequest, true);

    }

}
