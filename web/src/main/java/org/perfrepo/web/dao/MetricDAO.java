/**
 * PerfRepo
 * <p>
 * Copyright (C) 2015 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package org.perfrepo.web.dao;

import org.perfrepo.web.model.Metric;
import org.perfrepo.web.model.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * DAO for {@link Metric}
 *
 * @author Pavel Drozd (pdrozd@redhat.com)
 * @author Michal Linhard (mlinhard@redhat.com)
 */
public class MetricDAO extends DAO<Metric, Long> {

   public Metric getByName(String name) {
      Map<String, Object> params = new HashMap();
      params.put("name", name);
      List<Metric> result = findByNamedQuery(Metric.FIND_BY_NAME, params);

      if (result.isEmpty()) {
         return null;
      }

      return result.get(0);
   }

   public Set<Metric> getMetricsByTest(Test test) {
      Map<String, Object> params = new HashMap();
      params.put("test", test);
      return new HashSet<>(findByNamedQuery(Metric.FIND_BY_TEST, params));
   }

}