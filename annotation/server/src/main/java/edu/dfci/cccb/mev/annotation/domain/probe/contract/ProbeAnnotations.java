package edu.dfci.cccb.mev.annotation.domain.probe.contract;

import java.util.List;

import edu.dfci.cccb.mev.dataset.domain.contract.Dimension;

public interface ProbeAnnotations {
  List<ProbeAnnotation> get(Dimension dimension);
}
