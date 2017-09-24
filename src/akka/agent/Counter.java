package four;

import akka.actor.UntypedActor;
import akka.dispatch.Mapper;
import scala.concurrent.Future;


/**
 * Created by BlueSky on 2/16/2017.
 */
public class CounterActor extends UntypedActor {

    Mapper addMapper = new Mapper<Integer, Integer>() {
        @Override
        public Integer apply(Integer parameter) {
            return parameter + 1;
        }
    };

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof Integer) {
            for (int i = 0; i < 10000; i++) {
                Future f = AgentActor.countAgent.alter(addMapper);
                AgentActor.futures.add(f);
            }
            getContext().stop(getSelf());
        }
    }
}
