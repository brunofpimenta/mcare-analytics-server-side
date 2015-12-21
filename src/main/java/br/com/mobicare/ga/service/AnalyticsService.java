package br.com.mobicare.ga.service;

import br.com.mobicare.ga.adapter.GoogleAdapter;
import br.com.mobicare.ga.exception.HitException;
import br.com.mobicare.ga.request.HitRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnalyticsService {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GoogleAdapter googleAdapter;

    /**
     * Envia o hit para o GA.
     *
     * @param hitRequest request com as opcoes do hit.
     * @throws HitException excecao lancada quando algum parametro obrigatorio nao e informado.
     */
    public void hit(HitRequest hitRequest) throws HitException {
        LOG.info("Performing hit request...");

        hitRequest.validate();

        googleAdapter.hit(hitRequest, false);

        LOG.info("Hit Request Succeded.");

    }

    /**
     * Envia o hit para um endpoint de validacao. (ver: https://developers.google.com/analytics/devguides/collection/protocol/v1/validating-hits)
     *
     * @param hitRequest request com as opcoes do hit.
     * @throws HitException excecao lancada quando algum parametro obrigatorio nao e informado.
     */
    public String hitDebug(HitRequest hitRequest) throws HitException {
        LOG.info("Performing hit request for DEBUG...");

        hitRequest.validate();

        return googleAdapter.hit(hitRequest, true);

    }

}
