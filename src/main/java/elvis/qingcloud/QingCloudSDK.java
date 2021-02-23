package elvis.qingcloud;

import com.qingcloud.sdk.config.EnvContext;
import com.qingcloud.sdk.exception.QCException;
import com.qingcloud.sdk.service.InstanceService;
import com.qingcloud.sdk.service.Types;

public class QingCloudSDK {

    public static void main(String[] args) {
        EnvContext context = new EnvContext("EVZWGKFNMYKXTMCLELXR", "7tVicwbURPVMpuf5rWl8rW8lagVUEpzT7hSi3GvS");
        context.setProtocol("http");
        context.setHost("api.alphacloud.com");
        context.setPort("7777");
        context.setZone("test");
        context.setApiLang("zh-cn"); // optional, set return message i18n, default to us-en
        InstanceService service = new InstanceService(context);

        InstanceService.DescribeInstancesInput input = new InstanceService.DescribeInstancesInput();
        input.setLimit(1);

        try {
            InstanceService.DescribeInstancesOutput output = service.describeInstances(input);
            for (Types.InstanceModel model : output.getInstanceSet()) {
                System.out.println("==================");
                System.out.println(model.getInstanceID());
                System.out.println(model.getInstanceName());
                System.out.println(model.getImage().getImageID());
                for (Types.NICVxNetModel vxNetModel : model.getVxNets()) {
                    System.out.println("==================");
                    System.out.println(vxNetModel.getVxNetID());
                    System.out.println(vxNetModel.getVxNetType());
                }
            }
        } catch (QCException e) {
            e.printStackTrace();
        }
    }
}
